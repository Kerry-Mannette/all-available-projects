using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Rentals
{
    public class DeleteModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesRentalsContext _context;

        public DeleteModel(RazorPagesRental.Data.RazorPagesRentalsContext context)
        {
            _context = context;
        }

        [BindProperty]
        public Rentals Rentals { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var rentals = await _context.Rentals.FirstOrDefaultAsync(m => m.Id == id);

            if (rentals is not null)
            {
                Rentals = rentals;

                return Page();
            }

            return NotFound();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var rentals = await _context.Rentals.FindAsync(id);
            if (rentals != null)
            {
                Rentals = rentals;
                _context.Rentals.Remove(Rentals);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
